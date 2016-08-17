using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JordanRiver
{
    class Program
    {
        static void Main(string[] args)
        {
            CartService cartService = new CartService();
            cartService.AddItemToCart("test", new Item());
        }
    }
}
