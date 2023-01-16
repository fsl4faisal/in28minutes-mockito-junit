package com.in28minutes.powermocks;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UtilityClass.class})
class SystemUnderTestTest {

    @Mock
    Dependency dependencyMock = mock(Dependency.class);

    @InjectMocks
    SystemUnderTest systemUnderTest = new SystemUnderTest(dependencyMock);

    @Test
    public void powerMockito_MockingAStaticMethodCall() {

        when(dependencyMock.retrieveAllStats()).thenReturn(
                Arrays.asList(1, 2, 3));

        PowerMockito.mockStatic(UtilityClass.class);

        when(UtilityClass.staticMethod(anyLong())).thenReturn(150);

        assertEquals(150, systemUnderTest.methodCallingAStaticMethod());

        //To verify a specific method call
        //First : Call PowerMockito.verifyStatic()
        //Second : Call the method to be verified
        PowerMockito.verifyStatic();
        UtilityClass.staticMethod(1 + 2 + 3);

        // verify exact number of calls
        PowerMockito.verifyStatic(Mockito.times(1));

    }
}