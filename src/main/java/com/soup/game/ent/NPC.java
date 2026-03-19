package com.soup.game.ent;

import com.soup.game.enums.Role;
import com.soup.game.enums.Sex;
import com.soup.game.intf.Entity;

import java.util.Random;

/**
 * Represents a non-player character (NPC) in the game world.
 * <p>
 * Each NPC has a unique ID, a name, age, sex, and a role. Roles
 * determine the NPC's occupation or function in the game (e.g., Farmer,
 * Blacksmith). NPCs can serve as quest givers, interactable characters,
 * or vendors in the game.
 * </p>
 */
@Entity(type = "NPC")
public class NPC {
    private static final Random random = new Random();
    private static int NEXT_ID = 1;
    private final long id;
    private final String name;
    private final Sex sex;
    private final Role role;
    private final int age;

    /**
     * Constructs a new NPC with everything randomized.
     * <p>
     * The NPC is automatically assigned a unique ID, random name,
     * random sex, and a random role. The age is overridden to a
     * random value between 18 and 95.
     * </p>
     */
    public NPC() {
        this.id = NEXT_ID++;
        this.name = genName();
        this.age = random.nextInt(18, 97);
        this.sex = Sex.random();
        this.role = Role.getRandomRole();
    }

    /**
     * Generates a random name out of 64 possibilities.
     * Said name gets assigned to the NPC at construction time
     * @return the randomized {@link String} name
     */
    public String genName() {
        String[] names = {
                "Alice", "Benjamin", "Charlotte", "Daniel", "Eleanor", "Frederick", "Grace", "Henry", 
                "Isabel", "Jack", "Katherine", "Leo", "Martha", "Nathan", "Olivia", "Peter", 
                "Quinn", "Rebecca", "Samuel", "Thomas", "Ursula", "Victor", "Wendy", "Xander", 
                "Yvonne", "Zachary", "Amelia", "Brandon", "Clara", "David", "Emily", "Felix", 
                "George", "Hannah", "Ian", "Julia", "Kevin", "Laura", "Michael", "Nina", 
                "Oliver", "Penelope", "Quentin", "Rose", "Simon", "Tina", "Ulrich", "Violet", 
                "William", "Ximena", "Yara", "Zane", "Aurora", "Blake", "Cecilia", "Dylan", 
                "Evelyn", "Finn", "Gabriella", "Harvey", "Iris", "Jacob", "Lily", "Miles", 
                "Noah", "Ophelia", "Patrick", "Quiana", "Rafael", "Sophia", "Trevor", "Una", 
                "Vincent", "Willa", "Xavier", "Yolanda", "Zara"
        };
        return names[random.nextInt(names.length)];
    }
    
    public long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Sex sex() {
        return sex;
    }

    public Role role() {
        return role;
    }

    public int age() {
        return age;
    }
}
