package fr.esiea.al5;

public class ItemSulfuras extends ItemAbstract {

	public ItemSulfuras(int sellIn, int quality) {
		super(SpecialItems.SULFURAS.getName(), sellIn, quality, false);
	}

	@Override
	public String getName() {
		return SpecialItems.SULFURAS.getName();
	}

	//@Override
	public void updateItemQuality() {
		// Sulfuras Item is Legendary so there is no update on Quality and SellIn
	}

}