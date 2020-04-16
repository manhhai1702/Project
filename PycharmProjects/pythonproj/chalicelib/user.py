import os
import hashlib
import bcrypt

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
def encodeBcrypt_password(password):
    hashed = bcrypt.hashpw(password.encode('utf-8'), bcrypt.gensalt())
    return hashed
def checkpass(password, hashed):
    passcheck = '1213456'
    ischeck = bcrypt.checkpw(hashed.encode('utf8'), password.encode('utf-8'))
    isam = bcrypt.checkpw(passcheck.encode('utf8'), password.encode('utf-8'))


    #check = bcrypt.checkpw(hashed, passcheck.encode('utf8'))
    #if bcrypt.checkpw(password.encode('utf-8'), hashed):
    #    return True

    return ischeck