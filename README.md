Aerial-Assist
=============

Java code for the 2014 Aerial Assist competition


#### TODO LIST 
## Before Robot is availible
[ ] Autonamous
[ ] Load ball 
[ ] Unload ball 
[ ] Test re-arm code
[ ] Make sure functions terminate correctly (see TODOs in code and notes below)
[ ] Open/Close Claw function (must terminate)
[ ] 

## After robot is available
[ ] Calibrate range-finding functions
[ ] Calibrate shooter angle/velocity
[ ] Fix hardware bug where arm will try to fire if cam goes down
[ ] Ensure motors on both arms rotate at the same speed using encoders


Terminating Commands
=====================
The program flow as each class is created goes like this: 
```
  initialize()
     v 
  execute()  < <  <
     v            ^
  isFinished() > ^ //return false
     v 
     v	//return true
     v 
  end()	
```
We should make all functions that will be used in a commandGroup sequence utilize
this structure, as it will greatly simplify coding. If you look at Laurel's code
in ReLoad.java, you'll see her code use this to great effect, which saves a great
of code, and if statements. Running through you'll see it runs like this
``` 
initialize : Sets up our sensor variables and calibration data

execute: Keeps the motor running 

isFinished: Checks a sensor to see if we have the ball yet

end: Stops the motors. 
```
Not a single if() statement! Coding bliss, right there. Plus, the huge advantage
will come when we put some code like this into a commandgroup, because we can 
reliably expect that this function will exit when it's supposed to. Easy!



