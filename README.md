# UDP Chat Application

This project is a simple chat application using User Datagram Protocol (UDP) built with Java. It consists of a server (`ChatServer.java`) and multiple clients (`ChatClient.java` and `ClientThread.java`) that can exchange messages in a terminal-based environment.

## Table of Contents

- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [UDP vs TCP](#udp-vs-tcp)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

To get started with this project, clone the repository to your local machine and ensure you have Java installed.

```bash
git clone https://github.com/your-repo-link/udp-chat-app.git
cd udp-chat-app
```

## Running the Application

1. Compile the Java files:

```bash
javac -d bin src/org/example/*.java src/org/example/client/*.java src/org/example/server/*.java
```

2. Start the ChatServer:

```bash
java -cp bin org.example.server.ChatServer
```

3. In separate terminal windows, start multiple ChatClient instances:

```bash
java -cp bin org.example.client.ChatClient
```

Follow the prompts in the client terminal to enter your name and send messages.

## UDP vs TCP

UDP (User Datagram Protocol) and TCP (Transmission Control Protocol) are both transport layer protocols used for sending data across a network. Here are the key differences between UDP and TCP:

- **Reliability**:
  - TCP is a connection-oriented protocol that ensures reliable data transmission, while UDP is a connection-less protocol that does not guarantee delivery.
- **Ordering**:
  - TCP ensures that data is delivered in the correct order, while UDP does not guarantee ordering.
- **Speed**:
  - UDP is generally faster than TCP as it has less overhead due to fewer features.
- **Usage**:
  - TCP is used for applications where data delivery and order are critical, like web browsing and email. UDP is used for real-time applications like video streaming and gaming where speed is more important than reliability.

## Project Structure

- `src/`: Contains all the source code for the project.
  - `org.example.server.ChatServer`: The server class responsible for forwarding messages between clients.
  - `org.example.client.ChatClient`: The client class for sending and receiving messages.
  - `org.example.client.ClientThread`: A thread class for continuously listening for incoming messages.

## Contributing

Feel free to fork this repository and submit pull requests. All contributions are welcome.

## License

This project is licensed under the MIT License.
```

Replace `https://github.com/your-repo-link/udp-chat-app.git` with the actual URL of your repository.

This README provides an overview of your project, instructions for getting started, running the application, an explanation of UDP vs TCP, a description of the project structure, and placeholders for contributing and license information.
