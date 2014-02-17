Aerial-Assist
=============

Java code for the 2014 Aerial Assist competition

##Copying Files for Netbeans
Since Netbeans' project files cause a lot of headaches when merging files, I've gotten them removed from GitHub's tracking. 
However, since these files are needed to start the project from a new clone, I've preserved them in the `Aerial-Assist/netbeans-project-files/nbproject` directory. 
After cloning the project, you'll need to copy the `Aerial-Assist/netbeans-project-files/nbproject/` directory into AerialAssist, so it winds up as 
`Aerial-Assist/AerialAssist/nbproject/`. After that, netbeans will pick up the project without incident, and will pick up all the needed files. You can leave it there, since after that GitHub will ignore them, and it won't cause any further issues.


## TODO LIST 
NetBeans has a built in built-in task manager, which you can access by using `Ctrl+F6` or going to `Window > Action Items`. It'll usually attach itself to the bottom window on a tab next to the compiler output. It'll look [like this](https://www.dropbox.com/s/iuc67blocm8n4z2/action-items.jpg) when it's opened, and double-clicking any item will take you straight to that point in the file. 

This should help keep you guys busy and coordinated! If you spot a problem somewhere in the code and can't figure it out, simply add a `//TODO` or a `//FIXME` and someone else can pick it up. After the fix is done, simply remove the comment and everything will be fixed. 


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
in ReLoad.java, you'll see her code use this to great effect, and simplifies a lot of variables and if statements. Running through you'll see it runs like this
``` 
initialize : Sets up our sensor variables and calibration data

execute: Keeps the motor running 

isFinished: Checks a sensor to see if we have the ball yet. 

end: Stops the motors. 
```
Not a single if() statement aside from our sensor check! Coding bliss, right there. Plus, the huge advantage
will come when we put some code like this into a commandgroup, because we can 
reliably expect that this function will exit when it's supposed to. Easy!





