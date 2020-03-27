﻿using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace nicos_signup
{
    public static class Crypto
    {
        public static string Hash(string value)
        {
            return Convert.ToBase64String(System.Security.Cryptography.SHA256.Create().ComputeHash(Encoding.UTF8.GetBytes(value)));
        }
    }
}