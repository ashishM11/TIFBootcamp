## Future Interface
<hr/>

**Future<V> is an interface introduced in Java 5 (java.util.concurrent). It represents the result of an asynchronous computation.**

<ins>Think of Future as a placeholder or promise for a value that will be available in the future once a background task completes</ins>.

1.  The Future interface in Java is used to represent the result of an asynchronous computation. 
2.  It allows a program to start a task in the background and continue with other operations without waiting for the task to complete. 
3.  When the result of the background task is needed, the program can retrieve it through the Future object.


**Here are some reasons why you might use the Future interface**:

**Asynchronous Operations:**
It enables you to perform long-running tasks, such as network requests or complex calculations, in the background, preventing the main thread from being blocked.<br/><br/>
**Improved Responsiveness:**
By not blocking the main thread, your application remains responsive to user interactions.<br/><br/>
**Task Management:**
Future provides methods to check if the task is complete, retrieve the result, and cancel execution if needed.<br/><br/>
**Concurrent Programming:**
It is a key component in concurrent programming, allowing multiple tasks to run simultaneously.<br/><br/>
**Cancellation:**
You can attempt to cancel the execution of the associated asynchronous task if it's no longer needed.<br/><br/>
**Error Handling:**
The Future interface can report exceptions that occurred during the execution of the task.<br/><br/>
**Task Status:**
You can check the status of a task (e.g., whether it's done or canceled).<br/><br/>
In summary, the Future interface is a powerful tool for managing asynchronous tasks in Java, improving performance and responsiveness by allowing tasks to run in the background while the main thread continues to execute other operations.


#### Key Methods of Future Interface

| Method               | Description                                                     |
| -------------------- | --------------------------------------------------------------- |
| `get()`              | Waits and returns the result                                    |
| `get(timeout, unit)` | Waits for specified time; throws `TimeoutException` if not done |
| `isDone()`           | Checks if the task is completed                                 |
| `isCancelled()`      | Checks if task was cancelled                                    |
| `cancel(true/false)` | Tries to cancel execution                                       |
