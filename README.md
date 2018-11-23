
# react-native-doc-scanner

## Getting started

`$ npm install react-native-doc-scanner --save`

### Mostly automatic installation

`$ react-native link react-native-doc-scanner`

### Manual installation


#### iOS

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
  	project(':react-native-doc-scanner').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-doc-scanner/android')
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
```
  