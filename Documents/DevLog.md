## ✍️ DevLog Updates
### [28/09/2026] — Repo Cleanup

- Updated DevLog



## ✨ Background

***HI PROGRAMMERS/DEVELOPERS!***
<br> Welcome to my first ever *(and actual)* Java Project: **Apple Catcher!**
<br> This game was created as my first personal Java project, with the sole purpose of kick-starting my journey as a developer.
<br> Java was my first ever programming language *(apart from Scratch, which we've all been through)*, and I studied it extensively during my Computer Science course at university. *(Thankfully, I graduated with a Bachelor's of Arts!)*

<br> Yes, I still consider myself a beginner who is slowly progressing towards an intermediate level.
<br> But I am continuously learning because, as we all know, the digital world is continuously evolving as we speak.
<br> And I thought to myself:
<br> ***"What would be a simple project that allows me to make my mark in this digital age?"***
<br> And then... 💡💡💡
<br> ***"My group made a recycling game in one of my modules. Why not remake the game?!"***
<br> So, **Apple Catcher** was born: a game where we catch falling apples from the sky and try to land them into our baskets!

<br> In the following section, I'll explain how the initial development of the game went.
<br> Since Java is my first ever language, it will be my choice of language for this project.

## 🧠 Development Of The Game

### --- 1 ~ Creating the Game Window ---
#### The Game Panel

- As we know, each and every app / game has a pop-up window. <br>
  Thankfully, Java has a built-in class that allows us to create a window for our game. <br>
  This class is called `JFrame` and is part of the `javax.swing` package.

- To access the `JFrame` class, we must import it into our program by using one of the following statements: <br>
  **`import javax.swing.JFrame;`** or **`import javax.swing.*;`** <br>
  These statements should be placed at the top of our main class.

- In the main method, we will create a `JFrame` object called `window`. <br>
  This is done by using the following statement: **`JFrame window = new JFrame();`** <br>
  Once that object is created, we can set our game properties by using the built-in `JFrame` methods.

  - Just a quick note: in order for our window to appear when running our program... <br>
  We set its visibility to `true` using the `setVisible()` method: **`window.setVisible(true);`**

- The game window should look like this: <br>
 ``// Insert Figure A here \\`` <br><br>

#### The Game Frame

- We will then create a new class called ``Panel.java``. <br>
The reason for this is class management: separating the panel from the main class helps prevent the code from becoming cluttered and allows us to independently modify or update the panel when needed.

- First, we must import the necessary packages, in this case:
  1. **``import javax.swing.JPanel``** will be used as the foundation for creating our own custom game panel.
  2. **``import java.awt.*;``** can be used to control the panel's appearance and functionality.

- For our class, we use ``extends`` to inherit the methods and functionality provided by the ``JPanel`` class. <br>
  - By using ``extends JPanel``, our ``Panel`` class becomes a subclass of ``JPanel``. This allows us to inherit the functionality provided by ``JPanel`` while also adding our own game-specific functionality.

- Then we will create a constructor for our ``Panel`` class, as shown below: <br>

```java
public Panel(){ 
        this.setPreferredSize(new Dimension(w, h)); // Sets the preferred panel dimensions
        this.setBackground(Color.BLACK); // Sets the default background colour
        this.setLayout(null); //Disables the layout manager
    }
```

- Onto our ``Main`` class, we create our ``Panel`` object using the **``Panel pan = new Panel();``** statement. <br>
  - Our next step is to add the ``Panel`` object onto our window, which is done by using: **``window.add(pan);``** <br>
  - Finally, **``window.pack();``** resizes the window to fit the Panel's preferred dimensions.

- The finishing result of this section should look like this: <br>
 ``// Insert Figure B here \\``  

 ---

### --- 2 ~ Creating A Game Loop ---

- Before making our entities, <br>
  we must understand how action-oriented games handle movement by using a simple analogy: <br>

  - Draw a character on a page, possibly in a walking motion. <br>Then, on the next page, draw the same character but in a slightly different position. <br>Keep drawing the same character several times.

  - If we quickly flip through the pages, it will appear as though the character is ***moving***. <br>This is essentially how animation works: by displaying multiple slightly different images in rapid succession. <br>The number of frames displayed per second is what we call **Frames Per Second (FPS)**.

  - But in terms of coding, we need to replicate this process by constantly updating and redrawing our game. <br>
    By doing this repeatedly, we can create the illusion of movement and animation. <br>
    This is where we introduce the concept of a **Game Loop**!

- To accomplish our game loop, we must use a `Thread` within our `Panel` class.
  - A **Thread** is essentially a separate path of execution within a program. <br>
    It allows a task to run concurrently while other parts of the program continue running.
  - In our case, we will use a Thread to continuously run our game loop in the background. <br>
  This allows the game to repeatedly update and redraw itself while the rest of the program remains responsive.
  - Threads are fundamental to our program because they allow our game loop to run asynchronously from our main thread, meaning the main thread does not have to wait for the game loop to finish.

- For the purpose of our game, we would like our game loop to run at **60 Frames Per Second (FPS)**. <br>
  Therefore, we will create a variable to store the value **60**: ``final int FPS = 60;``.

- We will then declare a ``Thread`` called `gameThread` in our program. <br>
We will also implement the ``Runnable`` interface by adding `implements Runnable` to our class declaration.
  - Since ``Runnable`` is an interface, we must implement its `run()` method in our program. <br>
  The `run()` method contains the code that we want our Thread to execute. <br>In our case, this is where we will eventually place our game loop.

- Our next step is to create a method that will launch the game thread. In our game, we will call this method `launch()`: <br>

```java
public void launch(){ 
        gameThread = new Thread(this); // Creates a new game thread
        gameThread.start(); // Starts the game thread
    }
```

- We can now start building our game loop. <br>
  In the `run()` method, we will create a `while` loop that continuously checks whether our `gameThread` reference is not `null`. <br>
  As long as the condition is `true`, the code inside the loop will continue to execute.

```java
public void run(){ 
    while(gameThread != null){ // As long as gameThread is not null, repeat the block of code below
    /* Our Block of Code*/
  }
}
```

- Our block of code needs to perform **2 main tasks**:

  1. **Update** — Update the game's state, such as the position of our entities.

  2. **Draw** — Redraw the game based on the updated state.

  - We will cover the **Update** and **Draw** methods in more detail in a later section. <br>
  For now, we will simply create the two methods.

#### Update Method

```java
public void update() {
    // We will put our entity update methods in here.
    // For now, this is just a placeholder.
}

```

#### Draw Method

```java
public void paintComponent(Graphics g) {
    // Built-in Java method that uses the Graphics class as its parameter
    super.paintComponent(g);

    // Casts g from Graphics to Graphics2D and stores it in g2
    Graphics2D g2 = (Graphics2D) g;
}
```

- We must also call these methods inside the ``run()`` method using the statements ``update();`` and ``repaint();``

  - ``update();`` calls our **Update** method to update the current state of the game.

  - ``repaint();`` requests that the game panel be redrawn, which will eventually call our ``paintComponent()`` method.

```java
public void run(){ 
    while(gameThread != null){ // As long as gameThread is not null, repeat the block of code below
    //Update Method
    update();

    //Draw Method
    repaint();
  }
}
```

 ---

### --- 3 ~ Creating The Catcher ---
#### Creating the ``Catcher`` Class

- ***This is the fun part of my build: creating the catcher entity.*** <br>
  In order to do this, I must build the ``Catcher`` class and create an object instance in the ``Panel`` class.<br>
  *Just a side note: We will be using keyhandlers for movement in a later time. <br>
  Right now we will put all of our attention on the creation of our catcher.*

- The first thing I did was create a separate package called ``Entity`` and within this package, I created an ``Entity`` class: <br> This allows me to store the ``x`` and ``y`` coordinates, as well as the ``speed`` variable, which will be used by future entities.

- Then we create the ``Catcher`` class, which ``extends Entity``. <br>
This allows the ``Catcher`` to inherit and access the ``x`` and ``y`` coordinates from the ``Entity`` class. <br>

- We will also have the following ``import`` statements:
  1. ``java.awt.Color;`` — Used to set the color of our Catcher. *This will be replaced later on.*
  2. ``java.awt.Graphics2D;`` — Used to draw the Catcher onto the game panel.
  3. ``Main.Panel;`` — Imports our ``Panel`` class from the ``Main`` package.

- Our next step is to write our constructor, which will allow us to create a ``Catcher`` object from our ``Panel`` class. <br>
 We first create a ``Panel`` object called ``gp``. Our constructor is then written using the following code:

```java
public Catcher(Panel gp){
    this.gp = gp; //assigns the Panel object passed into the constructor to the gp variable belonging to our Catcher object.

    defaultPos(); /*calls our defaultPos() method when the Catcher object is created. 
    Allowing us to automatically set its starting position.*/
}
```
<br>

#### Creating the graphics of our catcher:

- We then create the ``defaultPos()`` method, setting the Catcher's starting position within the game panel:

```java
public void defaultPos(){

    // Default position for our catcher, (Bottom Center of the Screen)

    x = ((gp.w / 2) - 50);

    y = (gp.h - 100);

}
```

- Finally we will implement our ``draw()`` method:

```java
public void draw(Graphics2D g2){
  g2.setColor(Color.white);
  g2.fillRect(x, y, 100, 100);
}
```

- To make our Catcher appear on the screen, we must first create a ``Catcher`` object within our ``Panel`` class. <br> Then, inside the ``paintComponent()`` method, we call the Catcher's ``draw()`` method using ``catcher.draw(g2);``.

- If we run our Java Code, it would look something like this: <br>
 ``// Insert Figure C here \\`` <br><br>

#### Making the game run 60FPS:
- Remember, we want our game to run 60 FPS, meaning we want our graphics to update 60 times per second. <br>
In order to make this possible, we have to update our **Game Loop.**

- Initially, my game loop called the ``update()`` and ``repaint()`` methods, <br>
Because of this, the game speed relied on the computer's execution speed.

- A better solution is using the **delta interval** technique... <br>
So back in our ``Panel`` class we will include the following variables:
  1. ``drawInterval`` - *(double)* - How long one frame should last, in nanoseconds. <br>
     - There are 1,000,000,000 nanoseconds in a second, so ``1000000000 / fps`` gives us the time per frame at 60 FPS.
     - ``double drawInterval = 1000000000 / fps;``
  2. ``delta`` - *(double)* - Tracks how much of a frame has "built up" so far. <br>
     - Once it reaches ``1``, a full frame's worth of time has passed.
     - ``double delta = 0;``
  3. ``lastTime`` - *(long)* - The time recorded on the previous pass of the loop, taken from ``System.nanoTime()``.
      - ``long lastTime = System.nanoTime();``
  4. ``currentTime`` - *(long)* - The time recorded on the current pass of the loop.
      - ``long currentTime;``

- We will create a while loop that checks if ``gameThread`` is not ``null``.
  - ``while(gameThread != null){``

- Then, inside the loop, each pass we:
  1. Get the ``currentTime``.
  2. Add ``(currentTime - lastTime) / drawInterval`` to ``delta``. <br>This is the fraction of a frame that has passed since the last pass.
  3. Set ``lastTime = currentTime`` so the next pass measures from now.
  4. If ``delta >= 1``, we ``update()``, ``repaint()``, and subtract ``1`` from ``delta``.

- The result: no matter how fast the computer spins the loop, ``update()`` and ``repaint()`` only run 60 times per second.

```java
while(gameThread != null){
    currentTime = System.nanoTime();
    delta += (currentTime - lastTime) / drawInterval;
    lastTime = currentTime;

    if(delta >= 1){
        update();
        repaint();
        delta--;
    }
}
```