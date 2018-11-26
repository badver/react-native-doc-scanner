import {Platform} from 'react-native';
import AndroidDocScanner from './index.android'
import IosDocScanner from './index.ios'

const DocScanner = Platform.select({
  ios: () => IosDocScanner,
  android: () => AndroidDocScanner
})()

export default DocScanner;
