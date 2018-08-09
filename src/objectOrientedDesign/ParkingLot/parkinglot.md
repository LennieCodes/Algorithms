# Design a parking lot using object oriented principles


## Assumptions being made:
This ParkingLot has 1 level. This parking lot does not care about what vehicles are stored in a spot.
This lot can hold 100 ParkingSpots.
```java

public class ParkingLot {
  public ArrayList<ParkingSpot> parkingManafest;
  private final int lotSize = 100;
  
  public ParkingLot() {
    // initialize with 100 spots
    this.parkingManafest = new ArrayList<ParkingSpot>();
    ParkingSpot spot;

    for (int i = 0; i < lotSize; i++) {
      spot = new ParkingSpot();
      this.parkingManafest.add(spot);
    }
  }

  public void park(Vehicle vehicle) {
    ParkingSpot spot;
    for (int i = 0; i < lotSize; i++) {
      spot = this.parkingManafest.get(i);
      if (spot.isOccupied == false) {
        spot.addVehicle(vehicle);
        return;
      }
    }
  }

  public Vehicle retrieveVehicle(int key) {
    ParkingSpot spot;
    for (int i = 0; i < lotSize; i++) {
      spot = this.parkingManafest.get(i);
      if (spot.isOccupied == true && spot.vehicle.key == key) {
        return spot.removeVehicle();
      }
    }
    throw new Exception('Vehicle with key' + key + ' was not found in lot');
  }
}


public class ParkingSpot {
  public Vehicle vehicle;
  public bool isOccupied; 

  public ParkingSpot() {
    this.isOccupied = false;
  }

  public void addVehicle(Vehicle vehicle) {
    if (this.isOccupied == false) {
      this.vehicle = vehicle;
      this.isOccupied = true;
    } else { 
      throw new Exception("Cannot add vehicle because spot is occupied."); 
    }
  }

  public Vehicle removeVehicle() {
    if (this.isOccupied == true) {
      this.isOccupied = false;
      return this.vehicle;
    }
    throw new Exception("Attempting to remove vehicle from empty parking spot");
  }
}

public class Vehicle {
  public int key;

  public Vehicle(int key) {
    this.key = key;
  }
}

```