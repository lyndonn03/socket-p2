## About the Project

This small project is all about showing you how the `Thread per Request` model works. It is a simplified model of how server deals with client requests in which the concept is very similar to a production grade servers who uses this kind of model (not the same though since there is a lot of optimization, features and security implementations implemented in a production grade servers).

<br>

## Running the Project

The repository has two parts, the server and the client. These are two different applications, so to run these, you need to run the two applications individually. You must first run the server and run the client. You can use your favorite IDE or text editor to run these easily. Otherwise, you need to compile and run these applications using `Java CLI`.

<br>

## About the Thread per Request Model

In a “thread per request” model, the system allocates or uses a new thread to handle each incoming request, and when that request is complete, it disposes the thread or deallocates the thread to be reused on other requests. 

In this application, the server has a threadpool. This threadpool handles the request and sends a response to the client. Once the response is sent, it closes the socket connection and ends the program in that thread, leaving the thread inactive and ready for other incoming requests. 

<br>

![Thread per Request model drawio](https://user-images.githubusercontent.com/42237180/196432185-b2d989a8-ab0d-49aa-8969-c31a0bf91928.png)





