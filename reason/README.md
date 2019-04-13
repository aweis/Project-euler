# reason


[![CircleCI](https://circleci.com/gh/yourgithubhandle/reason/tree/master.svg?style=svg)](https://circleci.com/gh/yourgithubhandle/reason/tree/master)


**Contains the following libraries and executables:**

```
reason@0.0.0
│
├─test/
│   name:    TestReason.exe
│   main:    TestReason
│   require: reason.lib
│
├─library/
│   library name: reason.lib
│   namespace:    Reason
│   require:
│
└─executable/
    name:    ReasonApp.exe
    main:    ReasonApp
    require: reason.lib
```

## Developing:

```
npm install -g esy
git clone <this-repo>
esy install
esy build
```

## Running Binary:

After building the project, you can run the main binary that is produced.

```
esy x ReasonApp.exe 
```

## Running Tests:

```
# Runs the "test" command in `package.json`.
esy test
```
