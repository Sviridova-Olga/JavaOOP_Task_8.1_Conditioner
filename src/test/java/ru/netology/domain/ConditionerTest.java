package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConditionerTest {

    Conditioner conditioner = new Conditioner();

    private void initFields() {
        conditioner.setMaxTemperature(30);
        conditioner.setMinTemperature(15);
        conditioner.setName("Mitsubishi");
        conditioner.setOn(true);
    }

    @Test
    public void shouldIncreaseCurrentTemperature() {
        initFields();
        conditioner.setCurrentTemperature(29);
        conditioner.increaseCurrentTemperature();

        assertEquals(30, conditioner.getCurrentTemperature());
    }

    @Test
    public void shouldIncreaseCurrentTemperatureEqualMaxTemperature() {
        initFields();
        conditioner.setCurrentTemperature(30);
        conditioner.increaseCurrentTemperature();

        assertEquals(30, conditioner.getCurrentTemperature());
    }

    @Test
    public void shouldDecreaseCurrentTemperature() {
        initFields();
        conditioner.setCurrentTemperature(30);
        conditioner.decreaseCurrentTemperature();

        assertEquals(29, conditioner.getCurrentTemperature());
    }

    @Test
    public void shouldDecreaseCurrentTemperatureEqualMinTemperature() {
        initFields();
        conditioner.setCurrentTemperature(15);
        conditioner.decreaseCurrentTemperature();

        assertEquals(15, conditioner.getCurrentTemperature());
    }

    @Test
    public void shouldCurrentTemperatureLessMinTemperature() {
        initFields();
        conditioner.setCurrentTemperature(14);

        assertEquals(0, conditioner.getCurrentTemperature());
    }

    @Test
    public void shouldCurrentTemperatureMoreMaxTemperature() {
        initFields();
        conditioner.setCurrentTemperature(31);

        assertEquals(0, conditioner.getCurrentTemperature());
    }
}
