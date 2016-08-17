using System.IO;
using Newtonsoft.Json;

namespace JordanRiver
{
    internal class CartService
    {

        public void AddItemToCart(string cartId, Item item)
        {
            Cart cart;

            //Fetch the cart details from a json file.
            using (FileStream fs = File.Open(@"c:\cart" + cartId + ".json", FileMode.Open))
            {
                using (StreamReader sr = new StreamReader(fs))
                using (JsonReader jr = new JsonTextReader(sr))
                {
                    JsonSerializer serializer = new JsonSerializer();
                    cart = serializer.Deserialize<Cart>(jr);
                }
            }

            //Add the item to the cart
            cart.Items.Add(item);

            //Store again the update cart in the json file.
            using (FileStream fs = File.Open(@"c:\cart" + cartId + ".json", FileMode.Open))
            {
                using (StreamWriter sw = new StreamWriter(fs))
                using (JsonWriter jw = new JsonTextWriter(sw))
                {
                    jw.Formatting = Formatting.Indented;

                    JsonSerializer serializer = new JsonSerializer();
                    serializer.Serialize(jw, cart);
                }
            }
        }
    }
}
