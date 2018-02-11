package fr.esiea.al5;

public class ItemSulfuras extends ItemAbstract {

	public ItemSulfuras() {
		super(SpecialItems.SULFURAS.getName(), 0, 80, false);
	}

	@Override
	public String getName() {
		return SpecialItems.SULFURAS.getName();
	}

	@Override
	public void updateItemQuality() {
		// Sulfuras Item is Legendary so there is no update on Quality and SellIn
	}

}