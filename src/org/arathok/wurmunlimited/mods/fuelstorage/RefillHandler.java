package org.arathok.wurmunlimited.mods.fuelstorage;


import com.wurmonline.math.TilePos;
import com.wurmonline.server.Items;
import com.wurmonline.server.Server;
import com.wurmonline.server.Servers;

import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.ItemList;
import com.wurmonline.server.zones.VolaTile;
import com.wurmonline.server.zones.Zone;
import com.wurmonline.server.zones.Zones;
import org.gotti.wurmunlimited.modloader.classhooks.HookManager;
import org.gotti.wurmunlimited.modloader.classhooks.InvocationHandlerFactory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;


public class RefillHandler
{


            public static long nextpoll=0;
            public static long nextrefillpoll=0;
            public static List<Item> fuelStorages = new LinkedList<>();

            public static void PollFurnaces()
            {
                long time= System.currentTimeMillis();
                Item[] allItems;
                allItems = Items.getAllItems();

                if (time > nextpoll)
                {
                    for (Item oneItem : allItems)
                    {
                        if (oneItem.getTemplate() == FuelStorageItems.fuelStorage )
                        {
                            if (!fuelStorages.contains(oneItem)) {
                                fuelStorages.add(oneItem);
                                FuelStorage.logger.log(Level.INFO, "Polling Fireplaces. Found " + fuelStorages.size() + " firing Places");
                            }
                        }
                    }
                    nextpoll=time+300000;
                }

            }
/* // OLD
            public static void Refill()
             {
                 long time = System.currentTimeMillis();
                 if (time>nextrefillpoll)
                 {
                     FuelStorage.logger.log(Level.INFO, "Refuelling:");
                     for (Item fuelStorageToEdit : fuelStorages)
                     {
                         Item accompanyingFurnace = null;
                         Item fuelItemWithLowestEfficiency = null;
                         VolaTile tileOfFurnaceToEdit;
                         if (fuelStorageToEdit.isOnSurface())
                             tileOfFurnaceToEdit = Zones.getTileOrNull(fuelStorageToEdit.getTilePos(), true);
                         else
                             tileOfFurnaceToEdit = Zones.getTileOrNull(fuelStorageToEdit.getTilePos(), false);

                         Iterator<Item> otherItemsOnTile = Arrays.stream(tileOfFurnaceToEdit.getItems()).iterator();
                         while (otherItemsOnTile.hasNext())
                         {
                             Item compare = otherItemsOnTile.next();
                             if (compare.getTemplateId() == ItemList.forge || compare.getTemplateId() == ItemList.kiln || compare.getTemplateId() == ItemList.stoneOven || compare.getTemplateId() == ItemList.still || compare.getTemplateId() == ItemList.smelter)
                             {
                                 accompanyingFurnace = compare;

                             }


                         }

                         Item[] fuelItems = fuelStorageToEdit.getItemsAsArray();
                         Item searchFuelItemWithLowestEfficiency;
                         Iterator<Item> pickLowestFuelEfficiency = Arrays.stream(fuelItems).iterator();
                         int fuelEfficiency = 10;
                         while (pickLowestFuelEfficiency.hasNext())
                         {


                             searchFuelItemWithLowestEfficiency = pickLowestFuelEfficiency.next();
                             if (Item.fuelEfficiency(searchFuelItemWithLowestEfficiency.getMaterial()) < fuelEfficiency)
                                 fuelItemWithLowestEfficiency = searchFuelItemWithLowestEfficiency;


                         }
                         if (fuelItemWithLowestEfficiency != null)
                         {
                             double newTemp = (fuelItemWithLowestEfficiency.getWeightGrams() * Item.fuelEfficiency(fuelItemWithLowestEfficiency.getMaterial()));
                             if (accompanyingFurnace != null && accompanyingFurnace.getTemperature() > 1000 && accompanyingFurnace.getTemperature() < 2000)
                             {
                                 short maxTemp = 30000;
                                 short newPTemp = (short) (int) Math.min(30000.0D, accompanyingFurnace.getTemperature() + newTemp);
                                 accompanyingFurnace.setTemperature(newPTemp);
                                 Items.destroyItem(fuelItemWithLowestEfficiency.getWurmId());

                                 FuelStorage.logger.log(Level.INFO, "fueled the fire place"+ accompanyingFurnace.getTemplate().getName()+ "@" +" "+ accompanyingFurnace.getTileX() +" "+ accompanyingFurnace.getTileY() + "with " + fuelItemWithLowestEfficiency.getTemplate().getName());
                             }
                         }
                     }
                     nextrefillpoll=time+60000;
                 }
             }

 */
//new
    public static void Refill()
    {


    }
}




