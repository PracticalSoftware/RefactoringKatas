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
            var path = @"c:\cart" + cartId + ".json";
            cart = Open(path);

            //Add the item to the cart
            cart.Items.Add(item);

            //Store again the update cart in the json file.
            Save(path, cart);
        }

        public Cart Open(string path)
        {
            Cart cart;
            using (FileStream fs = File.Open(path, FileMode.Open))
            {
                using (StreamReader sr = new StreamReader(fs))
                using (JsonReader jr = new JsonTextReader(sr))
                {
                    JsonSerializer serializer = new JsonSerializer();
                    cart = serializer.Deserialize<Cart>(jr);
                }
            }
            return cart;
        }

        public void Save(string path, Cart cart)
        {
            using (FileStream fs = File.Open(path, FileMode.Open))
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
