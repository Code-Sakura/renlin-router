# renlin-router

## About

* A routing library for renlin

### repository

* https://central.sonatype.com/artifact/net.kigawa/renlin-router

## Using

### Requirement

* kotlin
    * jvm
    * js

### Getting Started

#### 1. add to dependency

pom.xml

```pom.xml
<dependency>
  <groupId>net.kigawa</groupId>
  <artifactId>renlin-router</artifactId>
  <version>{version}</version>
</dependency>
```

build.gradle.kts

```build.gradle.kts
implementation("net.kigawa:renlin:{version}")
```

#### 2. write the code

write a root component
```kotlin
class SampleComponent(
    val name: String,
    val sub: Sub,
) {
    val root = div.component {
        t("test root")
        
        // call subcomponent
        sub.display {
        }

        fragment {
            div {
                fragment {
                    p {
                        t("text")
                    }
                }
            }
        }
        sub.controller {
        }
    }
}

```

write a subcomponent
```kotlin
class Sub(
    dispatcher: StateDispatcher,
) {
  val state: MutableState<String> = dispatcher.newState("state")

  val display = div.component {
    t("display")
    div {
      val value = state.useValue()
      t("display1")
      div {
        t("display1-1")
        p {
          t("display1-1-1 $value")
        }
      }
    }
  }
  val controller = div.component {
    t("controller")
  }
  // fragment component
  val test = fragment<FlowContent>().component { }
  val test1 = fragment<PhrasingContent>().component { }
  val test2 = fragment<FlowPhrasingIntersection>().component { }
}
```

set state
```kotlin
state.set("new value")
```

init endpoint
```kotlin
val root = document.getElementById("root") ?: throw Exception("Root not found")
val sub = Sub()
val sample = SampleComponent("sample", sub)
val dispatcher = HakateInitializer().newStateDispatcher()
Entrypoint(root).render(sample.root, dispatcher)
```

## Author

* kigawa
    * contact@kigawa.net

# Making

## Version

### Example: 9.1.2

* **9**: major, destructive
* **1**: miner, new function
* **2**: miner, bug fix
