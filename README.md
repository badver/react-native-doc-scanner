
# react-native-doc-scanner

## Document detection library

This is a compilation of two libraries:
###### iOS: https://github.com/Michaelvilleneuve/react-native-document-scanner
###### Android: https://github.com/jhansireddy/AndroidScannerDemo

I just want to have one library to include in my project. 
Details about iOS and Android implementations and usage at this moment only in their corresponding repositories.

## Demo

/ScannerDemo contains a test app I use for testing.

## Getting started

`$ npm install react-native-doc-scanner --save`

### Mostly automatic installation

`$ react-native link react-native-doc-scanner`

### Manual installation


#### iOS

Edit the info.plist file in XCode and add the following permission : NSCameraUsageDescription

Remember, this library uses your device camera, you can't run it on a simulator.

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-doc-scanner` and add `RNDocScanner.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNDocScanner.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import ru.badver.docscanner.RNDocScannerPackage;` to the imports at the top of the file
  - Add `new RNDocScannerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
    include ':react-native-doc-scanner'
    project(':react-native-doc-scanner').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-doc-scanner/android')
    
    include ':scanlibrary'
    project(':scanlibrary').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-doc-scanner/android/scanlibrary')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-doc-scanner')
  	```


## Usage
```javascript
import RNDocScanner from 'react-native-doc-scanner';

// TODO: What to do with the module?
RNDocScanner;

// Look at usage in original repositories.

```
  