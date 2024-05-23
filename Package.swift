// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "jaLogger",
    platforms: [
        .iOS(.v12)
    ],
    products: [
        .library(
            name: "jaLogger",
            targets: ["jaLogger"]
        )
    ],
    targets: [
        .binaryTarget(
            name: "jaLogger",
            url: "https://github.com/devggaurav/JAloggerlib/raw/main/framworkZip/jaLogger.xcframework.zip",
            checksum: "abc607dbf2dee0b97b10dfbaad012edb057506ec6a2dbd6381b094d2e777f917"
        )
    ]
)
