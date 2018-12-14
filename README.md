
# react-native-doc-scanner
Android only

## Document detection library

## Getting started

`$ npm install react-native-doc-scanner --save`

### Mostly automatic installation

`$ react-native link react-native-doc-scanner`

### Manual installation


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

RNDocScanner.scan().then(uri => ...);

```
  
