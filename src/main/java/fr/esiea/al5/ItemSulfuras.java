package fr.esiea.al5;

public class ItemSulfuras extends ItemAbstract {

	private static int SULFURAS_IS_AWESOME = 80;

    /**
     * Constructor of the item Sulfuras
     * @param sellIn : Number of days to sell the item
     */
	public ItemSulfuras(int sellIn) {
		super(SpecialItems.SULFURAS.getName(), sellIn, SULFURAS_IS_AWESOME, false);
	}

	@Override
    /** {@inheritdoc} */
	public String getName() {
		return SpecialItems.SULFURAS.getName();
	}

	@Override
    /** {@inheritdoc} */
	public void updateItemQuality() {
		// Sulfuras Item is Legendary so there is no update on Quality and SellIn
	}

}