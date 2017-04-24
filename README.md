# Robot Game Problem

Author: Tsunghan Lee

Date: Apr 23 2017


## Command usage:
Two methods are listed in the following.

### Method 1:
Execute  execute .jar file:

`java -jar GameProblem.jar <option>`

### Method 2:
Compile:

`javac GameProblem.java`

Execute method 2:

`java GameProblem <option>`

### Command arguments:
```
<option>  1 : for game version 1
          2 : for game version 2
```

### Game Running Format:
```
Location Format: [<x>,<y>] (Note:no space in between)
  ex. Location: [2,3]

Direction faced Format: (Note: either <N> or <S> or <E> or <W>)
  ex. Direction faced: N

Actions Format: <M>,<L>,<R> (Note:no space in between):
  ex. Actions: M,M,M,L,M,R,R,R

Maximum actions allowed Format: (Note: Integer only)
  ex. Maximum actions allowed: 4
```

## Design
Utilized Object-oriented design to achieve the goal of easy maintaining and
developing new features. Five classes are included, and each class has its
own tester to make sure that they perform correctly. When encountered Invalid
input, such as illegal location, exceptions are handled. Class are listed in
the following.

* Coordinate:

Store coordinate information (x,y) and corresponding operations,
i.e. move one step toward each direction.

* Agent:

Store an agent's information (current coordinates) and actions,
i.e. turn left, turn right, move one step forward.

* Game:

Basic game information data, involving an agent, and methods to
set initial condition, including location and direction faced.

* Game1:

Extending Game class and add action-taking sequence method to form
the version 1 game.

* Game2:

Extending Game class and add new feature to perform path searching in order
to become version 2 game.


## Algorithm
In the game version 2, path searching is implemented in the sense of
backtracking algorithm, which is similar to DFS with some modification.
In each step, it checks whether the agent satisfies the target direction and
target location. If it reaches the target, then add the path into the
solution ArrayList. If not and doesn't reach the maximum actions allowed, it
recursively do the searching. In the last case, the agent doesn't satisfy
the targeting condition but reaches the maximum actions allowed, it remove
the last step in the path, and return.
