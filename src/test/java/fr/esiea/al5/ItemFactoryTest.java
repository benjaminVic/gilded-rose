package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class ItemFactoryTest {

    @Test
    public void instanciateClassTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<ItemFactory> constructor = ItemFactory.class.getDeclaredConstructor();
        Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }
}
