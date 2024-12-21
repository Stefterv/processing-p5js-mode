# Processing P5 JS mode

I'd like to build a p5.js mode for Processing based around electron. This will have the effect that p5.js sketches can be run with local desktop persmissions. The ultimate goal of this mode is to make p5.js a first class citizen of Processing. 

### Ideal functionality (in order of importance)
- Wrap p5.js sketches in Electron (in poc)
- Access node functionality (in poc)
- Start and stop from the editor (in poc)
- Launch devtools from button in the editor
- Toggle to enable/disable hot-reload
- Download npm packages (and other package repos)
- Typescript support
- Export p5 sketches to standalone apps

### Known issues in POC
- Run button does not acturately reflect state of running app
- Running the sketch crashes if `npn install` is still running in the background
- General code quality
- Code lines do not work
- `Enter` key does not work
- No UI for adding libraries
- Sketch window is stuck at a certain size

### Technical challenges
- For optimal support we should connect a Java based JS debugger to the electron app
- Not having a node_modules folder per sketch would be awesome
- Including new functionality into p5 related to the electron bases
  - e.g Overwiting `createCanvas` to send a signal to electron to resize the window to the newly defined size.
 
### What I need help with
- My (Stef) focus is learning how Processing modes are developed. Details on the implementation on how to run `npm` within Java is less relevant to my goals within Processing (still very interesting)

### Future plans
- iOS wrapper
- Android wrapper
