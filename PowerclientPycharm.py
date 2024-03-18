import socket

PORT = 1050
HEADER = 64
DISCONNECT_MESSAGE = "!DISCONNECT"
FORMAT = 'utf-8'
SERVER = '10.225.18.125'
ADDR = (SERVER, PORT)
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(ADDR)

print(f"[server connected to ]{ADDR}")


def send(msg):
    message = msg.encode(FORMAT)
    msg_length = len(message)
    send_length = str(msg_length).encode(FORMAT)
    send_length += b' ' * (HEADER - len(send_length))
    client.send(message)


def recipe():
    mes = client.recv(2024).decode(FORMAT)
    print(mes)


# def check_string_in_docx(conn, file_name):
#     try:
#         with open(file_name, 'rb') as file:
#             content = file.read()
#
#             if content.__contains__(
#                     b"kong.automation.client - No drives available for any tests. Kong is going to idle."):
#                 print("print for logic :", content)
#               conn.
#                 breakpoint()
#     except FileNotFoundError:
#         print('file not found')

send("hey" "")
