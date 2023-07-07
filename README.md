# The flight of the starlings

## Github

flight_of_the_starling

## Diagrama de Clases

```mermaid
classDiagram
    note "From Point till Herd"
    Point <|-- MovingPoint
    MovingPoint <|-- FlyingPoint
    FlyingPoint <|-- SocialFlyingAnimal
    SocialFlyingAnimal <|-- Starling
    Herd--*SocialFlyingAnimal
    class Point{
        +getPositionY()
        +getPositionX()
        +InitRandomPosition()
    }
    class MovingPoint{
        +Point2D center
        +Path path
    }
    class FlyingPoint{
        +String shape
        +double speed
        +double direction
        +getPositionY()
        +getPositionX()
        +InitRandomPosition()
    }
    class SocialFlyingAnimal{
        +SocialFlyingAnimal leader
        +InitRandomPosition()
    }
    class Starling {
        -String group
        -String energyLevel
        -String adaptabilityLevel
        -String agilityLevel
        -String explorationLevel
        -String playfulnessLevel
    }
    class Herd{
        +List~Starling~  Starling
        +int total
        +double maxLeadership
        +setLeaderShip(SocialFlyingAnimal socialBird)
        +searchLeader(SocialFlyingAnimal socialBird)
    }


```
