# Patience Game

A Java implementation of the classic card game **Patience** (also known as **Solitaire**). This project models the components of the game, including cards, slots, and game logic, to create an interactive console-based experience.

---


## Project Structure

### Classes

1. **`Card`**  
   - Base class representing a generic card in the game.

2. **`NumberCard`**  
   - Subclass of `Card`, representing cards with numerical values.

3. **`SeedCard`**  
   - Subclass of `Card`, representing cards with specific suits (e.g., hearts, spades).

4. **`Slot`**  
   - Represents a slot where cards are placed.

5. **`SlotType`**  
   - Enum or class defining the types of slots (e.g., tableau, foundation, stock).

6. **`Game`**  
   - Contains the core game logic, including initialization, moves, and win conditions.

7. **`Main`**  
   - Entry point of the application.

---

## How to Run

1. **Prerequisites**:
   - Java.
   - A Java IDE or command-line environment for compilation and execution.

2. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd patience-game

4. **Run code**:
   the jar file is in out/artifacts/se_game_jar folder and it can be run using java -jar and its 
   directory command through terminal.

---

##How to play

Launch the game using the Main class.
Follow the on-screen instructions to move cards between slots.
The objective is to sort all cards into the foundation slots by suit in ascending order (Ace to King).
Play until you either win the game or run out of moves.





the jar file is in out/artifacts/se_game_jar folder and it can be run using java -jar and its directory command through terminal.
