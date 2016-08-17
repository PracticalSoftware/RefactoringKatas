namespace JordenRiver
{
    internal interface IPersister
    {
        void Save(string path, object cart);
        T Open<T>(string path);
    }
}