package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() { 
        assertEquals("Summit H.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("Summit-Haque", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_team() {
        Team t = Developer.getTeam();
        assertEquals("f25-00", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Summit H."),"Team members should contain Summit H.");
        assertTrue(t.getMembers().contains("Alice"),"Team members should contain Alice");
        assertTrue(t.getMembers().contains("Bob"),"Team members should contain Bob");
        assertTrue(t.getMembers().contains("Casey"),"Team members should contain Casey");
        assertTrue(t.getMembers().contains("Danny"),"Team members should contain Danny");
        assertTrue(t.getMembers().contains("Eve"),"Team members should contain Eve");
    }   
}
