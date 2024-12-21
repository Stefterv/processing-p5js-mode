# Processing P5 JS mode

I'd like to build a p5.js mode for Processing based around electron. This will have the effect that p5.js sketches can be run with local desktop persmissions. The ultimate goal of this mode is to make p5.js a first class citizen of Processing. 

## Running the POC
Currently setup for macOS, will do other platforms later. Assumes you have Processing installed in `/Applications/Processing.app`

- Open this repository in Intellij IDEA
- Wait for Gradle to download its things
- Run the Gralde task `runProcessing`
  - This will install the library in `~/Documents/Processing/Modes/p5js`
  - This will run a funky version of Processing


### Ideal functionality (in order of importance)
- Wrap p5.js sketches in Electron (in poc)
- Access node functionality (in poc)
- Start and stop from the editor (in poc)
- Launch devtools from button in the editor
- Toggle to enable/disable hot-reload
- Download npm packages (and other package repos) with UI
- Typescript support for sketches
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
- I'd like to have all our custom JS functionality to also be a proper JS project setup within this repo, not like I did it in the POC with some .js and .html files embedded as strings in the code.
- Not having a node_modules folder per sketch would be awesome
  - My current thinking is that we could have a single node_modules setup in the sketchbook, electron would be run from there and also that's where any installed npm packages would be installed to.
  - I thought of installing everything in `global` namespace but I think that will cause issues and also be a little bit insecure.
- Including new functionality into p5 related to the electron bases
  - e.g Overwiting `createCanvas` to send a signal to electron to resize the window to the newly defined size.
 
### What I need help with
- My (Stef) focus is learning how Processing modes are developed. Details on the implementation on how to run `npm` within Java is less relevant to my goals within Processing (still very interesting)

### Future plans
- iOS wrapper
- Android wrapper
This technique of wrapping a p5.js sketch in a runner (e.g. in the poc, `electron`) can also be applied to other platforms such as iOS and Android, providing a simple way for people to install their sketches as iOS and Android apps.
- Export as GitHub ready
  - Include automated actions to compile the sketch to native apps
  - Include a `package.json`
  - Remove any Processing file that would intefere
