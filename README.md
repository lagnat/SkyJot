# SkyJot
SkyJot Bukkit plugin

## Description
SkyJot is a Bukkit Minecraft plugin for writing block letters in the sky.  It was inspired by the (seemingly) unmaintained plugin called "SkyText".

### Usage
/skyjot write [ b:blockType ] [ j:left | center | right ] &lt;x> &lt;y> &lt;z> Text...  
/skyjot undo

### Notes
*  Newlines can be embedded with \n
*  Text direction is determined by the direction you are facing when you run the write command.  Text will be left-to-right from the perspective of the player.

### Example
/skyjot write b:17:2 ~ ~ ~ Hello\nWorld