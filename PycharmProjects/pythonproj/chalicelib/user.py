import os
import json
import getpass
import argparse
import hashlib
import hmac


def encode_password(password, salt=None):
    if salt is None:

        salt = hashlib.sha256(os.urandom(60)).hexdigest().encode('ascii')
    rounds = 100000
    hashed = hashlib.pbkdf2_hmac('sha256', password.encode('utf-8'), salt, rounds)
    return {
        'hash': 'sha256',
        'salt': salt,
        'rounds': rounds,
        'hashed': hashed,
    }