// SPDX-License-Identifier: MIT
pragma solidity ^0.8.25;

interface IERC20 {
    function totalSupply() external view returns (uint256);
    function balanceOf(address account) external view returns (uint256);
    function transfer(address recipient, uint256 amount) external returns (bool);
    function allowance(address owner, address spender) external view returns (uint256);
    function approve(address spender, uint256 amount) external returns (bool);
    function transferFrom(address sender, address recipient, uint256 amount) external returns (bool);

    event Transfer(address indexed from, address indexed to, uint256 value);
    event Approval(address indexed owner, address indexed spender, uint256 value);
}

abstract contract SireCoin is IERC20 {
    string public constant name = "SireCoin";
    string public constant symbol = "SC";
    uint8 public constant decimals = 18;

    mapping(address => uint256) private _balances;
    mapping(address => mapping (address => uint256)) private _allowances;

    uint256 private _totalSupply = 1e24; // 1 million tokens, for example

    constructor() {
        // Assign all tokens to the specified address
        _balances[0x13a369dCa21084d1615da20c8f5F5bbDE6934eD2] = _totalSupply;
        emit Transfer(address(0), 0x13a369dCa21084d1615da20c8f5F5bbDE6934eD2, _totalSupply);
    }

    receive() external payable {
        // Handle incoming Ether (optional logic)
    }
}
