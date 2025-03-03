package io.matsior.mockservice.masterdata;

import io.matsior.mockservice.destination.Destination;

public record Country(String name, String code) implements Destination {
}
