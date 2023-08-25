const simpleStorage = artifacts.require('SimpleStorage.sol');

contract('SimpleStorage', () => {
    it('Should update data', async() =>{
    const storage = await simpleStorage.new();
    await storage.updateData(10);
    const data = await storage.readData();
    assert(data.toString() === '10');

    });
});