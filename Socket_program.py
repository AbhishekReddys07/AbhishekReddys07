import socket
import threading


PORT = 1050
SERVER = socket.gethostbyname(socket.gethostname())
ADDR = (SERVER, PORT)
FORMAT = 'utf-8'
HEADER = 64
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(ADDR)
DISCONNECT_MESSAGE = "!DISCONNECT"
SIZE = 1024 * 2

# Define count outside the function to retain its value across calls
count = 0


def handle_client(conn, addr):
    connected = True
    while connected:
        try:
            msg = conn.recv(SIZE).decode(FORMAT)
            print(f"Message received from {addr}: {msg}")
            if find_string():
                sentData_ToClient(addr)
                break
        except ConnectionResetError:
            print(f"Connection with {addr} was forcibly closed by the client.")
            connected = False
    conn.close()
    print(f"Connection with {addr} closed.")


def start_server():
    print("Starting server...")
    server.listen()
    print(f"Server is listening on {SERVER}")
    while True:
        conn, addr = server.accept()
        thread = threading.Thread(target=handle_client, args=(conn, addr))
        thread.start()
        print(f"[ACTIVE CONNECTIONS]: {threading.active_count() - 1}")


def find_string():
    global count
    print("inside find string")
    search_string = b".........Not Available for any tests........"
    file_name = "C:Desktop/user/file.tlog"
    try:
        with open(file_name, 'rb') as file:
            content = file.read()
            if content.find(search_string):
                print("present ")

                return True
            else:
                print("search string could be fount")
            return False

    except FileNotFoundError:
        count += 1
        print(f"file not found in {file_name}")
        if count == 10:
            return True
    return False


def sentData_ToClient( addr):
    server.connect(addr)
    server.send(b"ffgdg you")


if __name__ == "__main__":
    print("Starting server...")
    start_server()
