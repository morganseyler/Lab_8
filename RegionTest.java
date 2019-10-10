/**
 * Lab 8
 *
 * Test suite for the Region enum.
 * 
 * @author Stephen
 * @version 2018-03-12
 *
 */
public class RegionTest
{    
    /**
     * Tests that Region.toString() returns the expected value for each region.
     */
    public void regionToStringTest() throws AssertException
    {
    	// TODO: implement.
        Assert.assertEquals("north", Region.NORTH.toString());
        Assert.assertEquals("east", Region.EAST.toString());
        Assert.assertEquals("south", Region.SOUTH.toString());
        Assert.assertEquals("west", Region.WEST.toString());
    }
}
