package io.matsior.mockservice.masterdata;

import io.matsior.mockservice.destination.Destination;

public record City(String name) implements Destination {
}
