Pod::Spec.new do |spec|
  spec.name = 'jaLogger'
  spec.version = '0.0.1' // Use the retrieved version
  spec.summary = 'A logging library for KMM'
  spec.homepage = 'https://github.com/devggaurav/JAloggerlib'
  spec.license = { :type => 'Apache-2.0', :file => 'LICENSE' }
  spec.author = { 'Gaurav' => 'dev.gauravchauhan@gmail.com' }
  spec.source = { :http => 'https://repo1.maven.org/maven2/io/github/devggaurav/jaLogger/0.0.1/jaLogger-0.0.1.zip' }
  spec.vendored_frameworks = 'jaLogger.framework'
  spec.platform = :ios, '10.0'
end