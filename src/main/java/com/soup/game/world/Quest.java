package com.soup.game.world;

import com.soup.game.ent.NPC;
import com.soup.game.enums.QuestType;
import com.soup.game.intf.Data;
import com.soup.game.intf.Item;
import com.soup.game.intf.World;

import java.util.Set;

/**
 * Represents a quest in the game world.
 * <p>
 * Quests are tasks given by NPCs and have specific objectives,
 * types, rewards, and conditions. They may be repeatable or one-time only.
 * </p>
 */
@World(entity = "quest")
@Data
public record Quest(long id, NPC giver, String name, QuestType type,
                    Set<Item> rewards, int required, boolean canRedo) {}
