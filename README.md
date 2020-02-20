# connect4
The project is a faithful representation of the famous board game, Connect4. 
Connect4 is an abstract two-player board game in which players initially choose a color/symbol and alternate in turn by placing pieces
or disks in one grid of 7 columns and 6 rows. The grid is placed in a vertical position and the disks, when inserted, occupy the first
position available starting from the bottom. The objective of the game is to be the first player to form a horizontal, vertical or 
diagonal line of 4 discs of their own color.

The implementation carried out allows you to select between three types of players: 
    - InteractivePlayer: the classic interactive player that inserts the position of the pieces from the keyboard. 
    - BotPlayer: a bot player that places the tokens randomly. 
    - StrategicPlayer: It is also a bot but it places the tokens following a "strategy", it always places in the top row where it placed 
      its opponent. In the case of a full column, place a square in the next column, instead if you are the first to play,
      choose a random column. 
      
The symbols used are CROSS (X) and CIRCLE (O), at the end of each game it is possible to start a new one or exit the game.

This project strictly follows the SOLID principles in order to favor extensibility and division of responsibilities between the
different parts.

## Execution

Build using gradle command:

```bash
gradle build
```

Run with:

```bash
gradle run --args="arg1 arg2"
```

The allowed arguments are: 
* `bot` : bot player who places checkers in a random way
* `strategic`: strategic player who uses an algorithm to decide in which position place the checkers.
* `interactive`: interactive player managed by the user

## Author

* **Yuri Paoloni** - [yuripaoloni](https://github.com/yuripaoloni)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
