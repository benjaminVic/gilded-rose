package fr.esiea.al5;

public class ItemSulfuras extends ItemAbstract {

    /**
     * Constructor of the item Sulfuras
     * @param sellIn : Number of days to sell the item
     * @param quality : Value of the item
     */
	public ItemSulfuras(int sellIn, int quality) {
		super(SpecialItems.SULFURAS.getName(), sellIn, quality, false);
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