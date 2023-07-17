import pandas as pd
import base64

# encryptionkey = pd.read_csv(r"I:/mini andrid test/code/app/src/main/python/decodekeynew.csv",sep=',', names=['Character', 'Byte'], header=None, skiprows=[0])
#
# df = pd.DataFrame(data=encryptionkey)
#
# df['Character'] = df['Character'].astype(str)
# df['Byte'] = df['Byte'].astype(str)

# def split(message):
#     return [char for char in message]
# message_split=message.split()



def enc(emessage,ekey):
    key=ekey
    message=emessage

#     encryptionkey = pd.read_csv(r"I:/mini andrid test/code/app/src/main/python/decodekeynew.csv",sep=',', names=['Character', 'Byte'], header=None, skiprows=[0])
#
#     df = pd.DataFrame(data=encryptionkey)
#
#     df['Character'] = df['Character'].astype(str)
#     df['Byte'] = df['Byte'].astype(str)

    coded_message = ""
    enc=[]
    for i in range(len(message)):
        key_c = key[i % len(key)]
        enc.append(chr((ord(message[i]) + ord(key_c)) % 256))
        coded_char=base64.urlsafe_b64encode("".join(enc).encode()).decode()
#     for i in range(len(coded_char)):
#         j = coded_char[i]
#         try:
#             coded_char2 = encryptionkey.loc[encryptionkey['Character'] == j, 'Byte'].iloc[0]
#             #print(type(coded_char))
#
#         # To handle if character is not in our decryption list
#         except:
#             print('unrecognized character')
#             coded_char = '@@@'

        #coded_message = coded_message + coded_char2
    return str(coded_char)


def dec(message,key):
    dec=[]
    message = base64.urlsafe_b64decode(message).decode()
    for i in range(len(message)):
        key_c = key[i % len(key)]
        dec.append(chr((256 + ord(message[i])- ord(key_c)) % 256))
    a = "".join(dec)
    return "".join(dec)