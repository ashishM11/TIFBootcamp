## Callable Interface
<hr/>

**Callable<V> is a functional interface in Java (added in Java 5)** that represents a task that returns a result and <ins>can throw a checked exception</ins>.

<b>The Callable interface in Java serves as a powerful tool for concurrent programming, offering key advantages over the Runnable interface, particularly when dealing with asynchronous tasks. Here's why you might choose to use Callable:</b>


1. **Returning Results**: <br/>Unlike Runnable, which is designed for tasks that don't produce a result, Callable allows tasks to return a value upon completion.<br/> This is crucial when you need to obtain the outcome of a computation or operation performed in a separate thread.<br/><br/>
2. **Exception Handling**: <br/>Callable enables tasks to throw checked exceptions, providing a mechanism for handling errors that might occur during execution. <br/>This allows for more robust error management in multi-threaded applications.<br/><br/>
3. **Integration with Future**: <br/>Callable is often used in conjunction with Future, which represents the result of an asynchronous computation.<br/>By submitting a Callable task to an ExecutorService, you obtain a Future object, allowing you to retrieve the result or check the task's status.<br/><br/>
4. **Asynchronous Operations**: <br/>Callable is particularly useful for managing long-running or I/O-bound operations without blocking the main thread.<br/>By offloading these tasks to separate threads, you can improve the responsiveness of your application.<br/><br/>
   In summary, Callable is preferred over Runnable when you need to retrieve a result from a task, handle exceptions, and manage asynchronous operations effectively. It provides a more flexible and robust approach to concurrency in Java.

#### Key Methods of Future Interface

| Method               | Description                                                     |
| -------------------- | --------------------------------------------------------------- |
| `get()`              | Waits and returns the result                                    |
| `get(timeout, unit)` | Waits for specified time; throws `TimeoutException` if not done |
| `isDone()`           | Checks if the task is completed                                 |
| `isCancelled()`      | Checks if task was cancelled                                    |
| `cancel(true/false)` | Tries to cancel execution                                       |
