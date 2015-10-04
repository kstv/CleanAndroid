# The files and modifications provided by Facebook are for testing and evaluation purposes only.  Facebook reserves all rights not expressly granted.

import re

jar_deps = []
for jarfile in glob(['libs/*.jar']):
  name = 'jars__' + re.sub(r'^.*/([^/]+)\.jar$', r'\1', jarfile)
  jar_deps.append(':' + name)
  prebuilt_jar(
    name = name,
    binary_jar = jarfile,
  )

android_library(
  name = 'all-jars',
  exported_deps = jar_deps,
)


android_build_config(
  name = 'build-config',
  package = 'com.github.promeg.doubanmovie',
)

APP_CLASS_SOURCE = 'app/src/main/java/com/github/promeg/doubanmovie/app/AppShell.java'

android_library(
  name = 'main-lib',
  srcs = glob(['app/src/main/java/**/*.java'], excludes = [APP_CLASS_SOURCE]),
  deps = [
    ':all-jars',
    ':model-lib',
    ':common-lib',
    ':xlog-idle',
    ':appcompat',
    ':build-config',
    ':supportv4',
    ':res',
    ':common-res',
    ':mvp',
    ':core',
    ':rxbinding',
    ':rxandroid',
  ],
  annotation_processors = ['dagger.internal.codegen.ComponentProcessor', 'butterknife.internal.ButterKnifeProcessor'],
  annotation_processor_deps = [':all-jars', ':guava'],
)

android_library(
  name = 'application-lib',
  srcs = [APP_CLASS_SOURCE],
  deps = [
    ':build-config',
    ':common-lib',
    ':jars__buck-android-support',
  ],
)

android_resource(
  name = 'res',
  package = 'com.github.promeg.doubanmovie',
  res = 'app/src/main/res',
  assets = 'app/src/main/assets',
  deps = [
    ':appcompat',
    ':model-res',
  ]
)

android_library(
  name = 'common-lib',
  srcs = glob(['common/src/main/java/**/*.java']),
  deps = [
    ':all-jars',
    ':common-res',
    ':appcompat',
    ':core',
    ':databindinglib',
    ':mvp',
    ':recyclerview',
    ':rxandroid',
    ':rxbinding',
    ':rxbindingappcompat',
    ':rxbindingrecyclerview',
    ':supportv4',
  ],
  annotation_processors = ['dagger.internal.codegen.ComponentProcessor'],
  annotation_processor_deps = [':all-jars', ':guava'],
)

android_resource(
  name = 'common-res',
  package = 'com.promeg.github.doubanmovie.common',
  res = 'common/src/main/res',
  deps = [
  ]
)

android_resource(
  name = 'model-res',
  package = 'com.github.promeg.doubanmovie.model',
  res = 'model/src/main/res',
  deps = [
  ]
)

android_library(
  name = 'model-lib',
  srcs = glob(['model/src/main/java/**/*.java']),
  deps = [
    ':common-lib',
    ':model-res',
    ':all-jars',
    ':rxandroid',
  ],
  annotation_processors = ['auto.parcel.processor.AutoParcelBuilderProcessor', 'auto.parcel.processor.AutoParcelProcessor','dagger.internal.codegen.ComponentProcessor'],
  annotation_processor_deps = [':all-jars', ':jars__auto-parcel-processor-0.3', ':jars__auto-parcel-0.3', ':guava', ':jars__auto-service-1.0-rc2', ':jars__auto-common-0.3'],
)

android_manifest(
  name = 'manifest',
  skeleton = 'app/src/main/AndroidManifest.xml',
  deps = [
    ':main-lib',
  ],
)

keystore(
  name = 'debug_keystore',
  store = 'keystore/debug.keystore',
  properties = 'keystore/debug.keystore.properties',
)

android_binary(
  name = 'doubanmovie',
  manifest = ':manifest',
  keystore = ':debug_keystore',
  use_split_dex = True,
  exopackage = True,
  exopackage_modes = ['secondary_dex'],
  primary_dex_patterns = [
    '^com/github/promeg/doubanmovie/app/AppShell^',
    '^com/github/promeg/doubanmovie/BuildConfig^',
    '^com/facebook/buck/android/support/exopackage/',
    '^com/promeg/github/doubanmovie/common/base/',
    '^com/promeg/github/doubanmovie/common/di/'
  ],
  deps = [
    ':main-lib',
    ':application-lib',
  ],
)


android_prebuilt_aar(
  name = 'appcompat',
  aar = 'libs/appcompat-v7-23.0.0.aar',
)
android_prebuilt_aar(
  name = 'core',
  aar = 'libs/core-1.3.1.aar',
)
android_prebuilt_aar(
  name = 'databindinglib',
  aar = 'libs/databinding-lib-1.0-rc1.aar',
)
android_prebuilt_aar(
  name = 'mvp',
  aar = 'libs/mvp-1.3.1.aar',
)
android_prebuilt_aar(
  name = 'recyclerview',
  aar = 'libs/recyclerview-v7-23.0.0.aar',
)
android_prebuilt_aar(
  name = 'rxandroid',
  aar = 'libs/rxandroid-1.0.1.aar',
)
android_prebuilt_aar(
  name = 'rxbinding',
  aar = 'libs/rxbinding-0.2.0.aar',
)
android_prebuilt_aar(
  name = 'rxbindingappcompat',
  aar = 'libs/rxbinding-appcompat-v7-0.2.0.aar',
)
android_prebuilt_aar(
  name = 'rxbindingrecyclerview',
  aar = 'libs/rxbinding-recyclerview-v7-0.2.0.aar',
)
android_prebuilt_aar(
  name = 'supportv4',
  aar = 'libs/support-v4-23.0.0.aar',
)
android_prebuilt_aar(
  name = 'xlog-idle',
  aar = 'libs/xlog-android-idle-2.1.1.aar',
)

prebuilt_jar(
    name = 'guava',
    binary_jar = 'guava-18.0.jar',
  )
