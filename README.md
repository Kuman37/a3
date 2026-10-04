# Assignment 3 | Bridge Pattern

Name: Aliman Kuandykov
Group: [SE-2523]  
Topic: A - Drawing  
Repository: [https://github.com/Kuman37/a3]  

## Topic

This project demonstrates the Bridge design pattern using shapes and renderers.

The abstraction hierarchy contains Shape, Circle, and Square.

The implementation hierarchy contains Renderer, VectorRenderer, RasterRenderer, and AsciiRenderer.

The Bridge pattern allows shapes and renderers to change independently.

## Role Map

| Role | Class | Source |
|---|---|---|
| Abstraction | Shape | src/Shape.java |
| A1 | Circle | src/Circle.java |
| A2 | Square | src/Square.java |
| Implementor | Renderer | src/Renderer.java |
| I1 | VectorRenderer | src/VectorRenderer.java |
| I2 | RasterRenderer | src/RasterRenderer.java |
| I3 | AsciiRenderer | src/AsciiRenderer.java |
| Client | Main | src/Main.java |

## Bridge Location

The bridge field is stored in Shape:

```java
private Renderer renderer;
```

The implementation is passed through the constructor:

```java
public Shape(String id, Renderer renderer)
```

The implementation can be changed at runtime using:

```java
public void setImplementation(Renderer renderer)
```

The main abstraction operation is:

```java
public abstract String execute();
```

Circle and Square use the stored Renderer reference inside their execute() methods.

## Build

Run from the project root:

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
```

## Run

```bash
java -cp out Main --demo
```

## Expected Results

### T1

Circle with VectorRenderer.

Expected:

```text
VECTOR circle radius=2
```

### T2

Circle with RasterRenderer.

Expected:

```text
RASTER circle radius=2
```

### T3

Square with VectorRenderer.

Expected:

```text
VECTOR square side=3
```

### T4

Square with RasterRenderer.

Expected:

```text
RASTER square side=3
```

### T5

The same Circle object first uses VectorRenderer and then changes to RasterRenderer.

Expected:

```text
sameObject=true
stateUnchanged=true
before=VECTOR circle radius=2
after=RASTER circle radius=2
```

The object reference is checked using ==.

The Circle ID and radius stay unchanged after replacing the renderer.

### T6

Circle with AsciiRenderer.

Expected:

```text
ASCII circle radius=2
```

### T7

Square with AsciiRenderer.

Expected:

```text
ASCII square side=3
```

Expected final summary:

```text
SUMMARY: 7/7 PASS
```

## Runtime Switching

The runtime switch is demonstrated in T5 in src/Main.java.

The same Circle object is created with VectorRenderer.

Then:

```java
t5.setImplementation(new RasterRenderer());
```

changes only the Renderer reference.

The Circle object itself remains the same.

The ID and radius also remain unchanged.

## Extension

The initial version contains:

- Renderer
- VectorRenderer
- RasterRenderer
- Shape
- Circle
- Square
- Main

After the base commit, AsciiRenderer was added as a new implementation.

The existing Shape, Circle, Square, Renderer, VectorRenderer, and RasterRenderer classes were not changed.

Only the new AsciiRenderer class and Main demonstration were added or updated.

This shows that a new implementation can be added independently.

## Bridge Pattern

Bridge separates abstraction from implementation.

In this project, shapes are one dimension:

- Circle
- Square

Renderers are another dimension:

- VectorRenderer
- RasterRenderer
- AsciiRenderer

Shape stores a reference to the Renderer interface.

Because of this, any shape can work with any renderer.

## Bridge vs Adapter

Bridge is used to separate two parts of a design so they can change independently.

Adapter is used to make incompatible interfaces work together.

In this project, Bridge is used because Shape and Renderer are designed as two separate hierarchies.

## Trade-off

One disadvantage of Bridge is that it creates more classes and can make a small program more complex.
