#require 'json'

#package = JSON.parse(File.read(File.join(__dir__, 'package.json')))

Pod::Spec.new do |s|
  s.name         = "RNDocScanner"
  s.version      = "1.0.0"
  s.summary      = "RNDocScanner"
  s.description  = <<-DESC
                  RNDocScanner ios impl
                   DESC
  s.homepage     = "https://github.com/author/RNDocScanner"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "10.0"
  # s.source     = { :git => "https://github.com/author/RNDocScanner.git", :tag => "master" }
  s.source       = { :path => "../node_modules/react-native-doc-scanner/ios" }
  s.source_files = "RNDocScanner/**/*.{h,m}"
  s.requires_arc = true

  s.dependency "React"
  s.dependency 'WeScan', '>= 0.9'

end

