package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestComponent;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    @Test
    public void equals_same_object_returns_true() {
        // same object reference should be equal
        Team same = team;
        assertTrue(team.equals(same));
    }

    @Test
    public void equals_different_type_returns_false() {
        // comparing to an object of a different type should return false
        String notATeam = "not-a-team";
        assertFalse(team.equals(notATeam));
    }

    @Test
    public void equals_same_name_and_same_members_returns_true() {
        Team other = new Team("test-team");
        assertTrue(team.equals(other), "Teams with same name and empty members should be equal");
    }

    @Test
    public void equals_same_name_different_members_returns_false() {
        Team other = new Team("test-team");
        other.addMember("Alice");
        assertFalse(team.equals(other), "Teams with same name but different members should not be equal");
    }

    @Test
    public void equals_different_name_returns_false() {
        Team other = new Team("different-team");
        assertFalse(team.equals(other), "Teams with different names should not be equal");
    }
    
    @Test
    public void hashCode_returns_correct_value() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}
