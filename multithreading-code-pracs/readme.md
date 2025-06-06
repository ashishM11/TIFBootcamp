# Thread Class Methods:


**1. Basic Methods:**

- public void run()
- public synchronized void start()
- public static native Thread currentThread()
- public final native boolean isAlive()


**2. Naming Methods:**

- public final String getName()
- public final synchronized void setName(String name)

**3. Daemon Thread Methods:**

- public final boolean isDaemon()
- public final void setDaemon(boolean isDaemon)

**4. Priority Methods:**

- public final int getPriority()
- public final void setPriority(int newPriority)

**5. Prevent Thread Execution Methods:**

- public static native void sleep(long millis) throws InterruptedException
- public static native void yield()
- public final void join() throws InterruptedException

**6. Interrupting Methods:**

- public void interrupt()
- public boolean isInterrupted()
- public static boolean interrupted()
