import hashlib
import hmac
import datetime
from uuid import uuid4
from chalicelib import user

import jwt
from chalice import UnauthorizedError


# TODO: Figure out what we want to do with this.
# We can either move this out to env vars in config.json,
# use KMS to encrypt/decrypt this value, or store this in SSM.
# Until we figure it out I'll store it here.
_SECRET = b'\xf7\xb6k\xabP\xce\xc1\xaf\xad\x86\xcf\x84\x02\x80\xa0\xe0'


def get_jwt_token(username, password, record):
    if user.checkpass(record[5], password):
        now = datetime.datetime.utcnow()
        unique_id = str(record[0])
        payload = {
            'sub': username,
            'iat': now,
            'nbf': now,
            'jti': unique_id,
            # NOTE: We can also add 'exp' if we want tokens to expire.
        }
        jwtEncode = jwt.encode(payload, _SECRET, algorithm='HS256').decode('utf-8')
        return jwtEncode
    raise UnauthorizedError('Invalid password')


def decode_jwt_token(token):
    return jwt.decode(token, _SECRET, algorithms=['HS256'])